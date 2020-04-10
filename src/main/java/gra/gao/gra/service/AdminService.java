package gra.gao.gra.service;

import gra.gao.gra.dto.AdminDTO;

public interface AdminService {
    public boolean determineAdminLogin(String uuid);
    public String adminLogin(AdminDTO adminDTO);
}
