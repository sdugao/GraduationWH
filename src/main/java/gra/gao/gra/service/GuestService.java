package gra.gao.gra.service;

import gra.gao.gra.dto.GuestDTO;
import gra.gao.gra.entity.Guest;

/**
 * @author:gao
 * @date:2020/3/16
 * @time:14:20
 * @version:0.0.1
 * @description:none
 */

public interface GuestService {

    public boolean determineGuestLogin(String uuid);
    public GuestDTO guestLogin(GuestDTO guestDTO);
    public String guestLoginByUUID(String uuid);
    public String determineUnameUsed(String uname);
    public String register(GuestDTO guestDTO);
    public String updateGuestInfo(GuestDTO guestDTO);
}
