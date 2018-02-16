package pl.kostrowski.finalny.converters;

import org.apache.commons.codec.digest.DigestUtils;
import pl.kostrowski.finalny.entities.MyUser;
import pl.kostrowski.finalny.entities.Region;
import pl.kostrowski.finalny.entities.Role;
import pl.kostrowski.finalny.restclients.dto.MyUserDto;

public class UserConverter {

    public MyUser convert(MyUserDto myUserDto) {

        MyUser converted = new MyUser();

        converted.setId(myUserDto.getId());
        converted.setName(myUserDto.getName());
        converted.setSurname(myUserDto.getSurname());
        converted.setRegion(Region.valueOf(myUserDto.getRegion()));
        converted.setRole(Role.valueOf(myUserDto.getRole()));
        converted.setPassword(DigestUtils.md5Hex(myUserDto.getPassword()));

        return converted;
    }
}
