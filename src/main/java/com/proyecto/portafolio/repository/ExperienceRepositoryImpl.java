package com.proyecto.portafolio.repository;

import com.proyecto.portafolio.model.Experience;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ExperienceRepositoryImpl implements IExperienceRepository{

    private final JdbcTemplate jdbcTemplate;

//    private final RowMapper<Experience> experienceRowMapper = (rs, rowNum) -> {
//        Experience experience = new Experience();
//        experience.setId(rs.getLong("id"));
//        experience.setJobTitle(rs.getString("job_title"));
//        experience.setCoompanyName(rs.getString("company_name"));
//        experience.setStarDate(rs.getObject("start_date", LocalDate.class).atStartOfDay());
//        experience.setEndData(rs.getObject("end_date", LocalDate.class).atStartOfDay());
//        experience.setDescription(rs.getString("description"));
//        experience.setPersonalInfoId(rs.getLong("personal_info_id"));
//        return experience;
//    };


    private final RowMapper<Experience> experienceRowMapper = (rs, rowNum) -> {
        Experience experience = new Experience();
        experience.setId(rs.getLong("id"));
        experience.setJobTitle(rs.getString("job_title"));
        experience.setCoompanyName(rs.getString("company_name"));

        // Obtener objetos de forma segura sin invocar métodos directamente
        LocalDate startDate = rs.getObject("start_date", LocalDate.class);
        LocalDate endDate = rs.getObject("end_date", LocalDate.class);

        // Asignación segura con verificación de null
        experience.setStarDate(startDate != null ? startDate.atStartOfDay() : null);
        experience.setEndData(endDate != null ? endDate.atStartOfDay() : null);

        experience.setDescription(rs.getString("description"));
        experience.setPersonalInfoId(rs.getLong("personal_info_id"));
        return experience;
    };

    public ExperienceRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Experience> findAll() {
        String sql = "SELECT id, job_title, company_name, start_date, end_date, description, personal_info_id FROM experiences";
        return jdbcTemplate.query(sql, experienceRowMapper);
    }

    @Override
    public Optional<Experience> findById(Long id) {
        String sql = "SELECT id, job_title, company_name, start_date, end_date, description, " +
                "personal_info_id FROM experiences WHERE id = ?";
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, experienceRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }


    @Override
    public Experience save(Experience experience) {
        if (experience.getId() == null) {
            // INSERT
            String sql = "INSERT INTO experiences (job_title, company_name, start_date, end_date, description, " +
                    "personal_info_id) VALUES (?, ?, ?, ?, ?, ?) RETURNING id";
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sql,
                        new String[]{"id"});
                ps.setString(1, experience.getJobTitle());
                ps.setString(2, experience.getCoompanyName());
                ps.setObject(3, experience.getStarDate());
                ps.setObject(4, experience.getEndData());
                ps.setString(5, experience.getDescription());
                ps.setLong(6, experience.getPersonalInfoId());
                return ps;
            }, keyHolder);

            experience.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        } else {
            // UPDATE
            String sql = "UPDATE experiences SET job_title = ?, company_name = ?, start_date = ?, end_date = ?, " +
                    "description = ?, personal_info_id = ? WHERE id = ?";
            jdbcTemplate.update(sql,
                    experience.getJobTitle(),
                    experience.getCoompanyName(),
                    experience.getStarDate(),
                    experience.getEndData(),
                    experience.getDescription(),
                    experience.getPersonalInfoId(),
                    experience.getId());
        }
        return experience;
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM experiences WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Experience> findByPersonalInfoId(Long personalInfoId) {
        String sql = "SELECT id, job_title, company_name, start_date, end_date, description, personal_info_id FROM experiences WHERE personal_info_id = ?";
        return jdbcTemplate.query(sql, experienceRowMapper, personalInfoId);
    }

}
