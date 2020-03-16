package gra.gao.gra.service;

import gra.gao.gra.dto.AdminDTO;

public interface AdminService {
    public boolean determineAdminLogin(AdminDTO adminDTO);
    public String adminLogin(AdminDTO adminDTO);
}
