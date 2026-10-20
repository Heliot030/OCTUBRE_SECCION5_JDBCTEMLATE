package com.proyecto.portafolio.repository;

import com.proyecto.portafolio.model.Skill;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class SkillRepositoryImpl implements ISkillRepository {

    private final JdbcTemplate jdbcTemplate;

    public SkillRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Skill> skillInfoRowMapper = (rs, numRow)->{
      Skill skillInfo = new Skill();
        skillInfo.setId(rs.getLong("id"));
        skillInfo.setName(rs.getString("name"));
        skillInfo.setLevelPercentage(rs.getInt("level_percentage"));
        skillInfo.setIconClass(rs.getString("icon_class"));
        skillInfo.setPersonalInfo(rs.getLong("personal_info_id"));
        return skillInfo;
    };

    @Override
    public Skill save(Skill skill) {
        if (skill.getId() == null){
            String sql = "INSERT INTO skills (name, level_percentage, icon_class, personal_info_id) "
                    + "VALUES (?, ?, ?, ?, ?)";
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection ->{
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                ps.setString(1,skill.getName());
                ps.setInt(2,skill.getLevelPercentage());
                ps.setString(3,skill.getIconClass());
                ps.setLong(4,skill.getPersonalInfo());
                return ps;
            },keyHolder);

            skill.setId(Objects.requireNonNull(keyHolder.getKey().longValue()));
        }else {
            String sql = "UPDATE skills SET name = ?, level_percentage = ?, icon_class = ?, personal_info_id = ? WHERE id = ?";
            jdbcTemplate.update(sql,
                    skill.getName(),
                    skill.getLevelPercentage(),
                    skill.getIconClass(),
                    skill.getPersonalInfo(),
                    skill.getId()
                    );
        }
        return skill;
    }

    @Override
    public Optional<Skill> findById(Long id) {
        String sql = "SELECT id, name, level_percentage, icon_class , personal_info_id From skills WHERE id= ?";
        try {
            return  Optional.ofNullable(jdbcTemplate.queryForObject(sql, skillInfoRowMapper, id ));
        }catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }

    @Override
    public List<Skill> findAll() {
        String sql = "SELECT id, name, level_percentage, icon_class , personal_info_id From skills";
        return jdbcTemplate.query(sql,skillInfoRowMapper);
    }

    @Override
    public void deleteById(Long id) {
        String sql = "Delete From skills Where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Skill> findByPersonalInfoId(Long personalInfo) {
        String sql = "SELECT id, name, level_percentage, icon_class, personal_info_id FROM skills WHERE personal_info_id = ?";
        return jdbcTemplate.query(sql, skillInfoRowMapper, personalInfo);
    }
}
