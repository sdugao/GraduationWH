package gra.gao.gra.service;

import gra.gao.gra.dto.GuestDTO;

/**
 * @author:gao
 * @date:2020/3/16
 * @time:14:20
 * @version:0.0.1
 * @description:none
 */

public interface GuestService {

    public boolean determineGuestLogin(GuestDTO guestDTO);
    public String guestLogin(GuestDTO guestDTO);
}
