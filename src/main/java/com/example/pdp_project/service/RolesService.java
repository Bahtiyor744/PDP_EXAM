package com.example.pdp_project.service;

import com.example.pdp_project.dto.RolesDTO;
import com.example.pdp_project.entity.Roles;
import com.example.pdp_project.mapper.RolesMapper;
import com.example.pdp_project.repo.RolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RolesService {

    private final RolesRepository rolesRepository;
    private final RolesMapper rolesMapper=RolesMapper.INSTANCE;

    public List<RolesDTO> getAllRoles() {
        List<Roles> roles=rolesRepository.findAll();
        return roles.stream()
                .map(rolesMapper::toRolesMapperDto)
                .collect(Collectors.toList());
    }

    public RolesDTO getRoleById(Integer id) {
        Optional<Roles> roles=rolesRepository.findById(id);
        return roles.map(rolesMapper::toRolesMapperDto).orElse(null);
    }

    public RolesDTO createRole(RolesDTO rolesDto) {
        Roles roles =rolesMapper.toRolesMapper(rolesDto);
        rolesRepository.save(roles);
        return rolesMapper.toRolesMapperDto(roles);
    }

    public RolesDTO updateRole(Integer id, RolesDTO rolesDto) {
        if(rolesRepository.existsById(id)) {
            Roles roles=rolesRepository.findById(id).get();
            roles.setId(id);
            rolesRepository.save(roles);
            return rolesMapper.toRolesMapperDto(roles);
        }
        return null;
    }

    public void deleteRole(Integer id) {
        rolesRepository.deleteById(id);
    }
}
