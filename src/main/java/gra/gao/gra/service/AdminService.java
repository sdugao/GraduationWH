package gra.gao.gra.service;

import gra.gao.gra.dto.AdminDTO;
import gra.gao.gra.dto.AdminPWD_DTO;

public interface AdminService {
    public boolean determineAdminLogin(String uuid);
    public String adminLogin(AdminDTO adminDTO);
    public String clearUUID();
    public String updatePWD(AdminPWD_DTO dto);
}
