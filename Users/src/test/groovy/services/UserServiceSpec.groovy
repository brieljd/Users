package services

import com.bci.users.dto.PhoneRequestDTO
import com.bci.users.dto.UserRequestDTO
import com.bci.users.dto.UserResponseDTO
import com.bci.users.entity.Phone
import com.bci.users.entity.User
import com.bci.users.repository.UserRepository
import com.bci.users.security.JwtTokenUtil
import com.bci.users.services.UserServiceImpl
import spock.lang.Specification

import java.time.LocalDateTime

class UserServiceSpec extends Specification {
    private UserServiceImpl userService
    private UserRepository userRepository
    private JwtTokenUtil jwtTokenUtil

    def setup() {
        this.userRepository = Stub(UserRepository.class)
        this.jwtTokenUtil = Stub(JwtTokenUtil.class)
        this.userService= new UserServiceImpl(userRepository,jwtTokenUtil)
    }
    def "validate user saved"() {


        given: "se ingresan los datos del usuario a registrar"

        List <Phone> phonesEntity  = new ArrayList<Phone>()
        phonesEntity.add(Phone.builder().countrycode("56").citycode("9").number("50451512").build())
        phonesEntity.add(Phone.builder().countrycode("56").citycode("9").number("12345678").build())

        this.userRepository.save(_)>>{ User.builder().
                id("").
                name("Gabriel").
                email("jimenezgabriel265@gmail.com").
                password("Briel1988").
                phones(phonesEntity).
                dateOfCreation(LocalDateTime.now()).
                dateOfModified(LocalDateTime.now()).
                lastLogin(LocalDateTime.now()).
                token("ab12cd34eh56i").
                isActive(true).
                build()}

        this.jwtTokenUtil.generateToken(_)>>{"ab12cd34eh56i"}

        List <PhoneRequestDTO> phones  = new ArrayList<PhoneRequestDTO>()
        phones.add(PhoneRequestDTO.builder().countrycode("56").citycode("9").number("50451512").build())
        phones.add(PhoneRequestDTO.builder().countrycode("56").citycode("9").number("12345678").build())

        UserRequestDTO userRequestDTO = UserRequestDTO.builder().
                name("Gabriel").
                email("jimenezgabriel265@gmail.com").
                password("Briel1988").
                phones(phones).
                build()

        when: "se invoca al registro del usuario"
        UserResponseDTO responseDTO=this.userService.save(userRequestDTO)

        then: "se evalua la respuesta del registro"
        responseDTO.getId()!=null
        responseDTO.getToken()!=null
        responseDTO.getName() == userRequestDTO.getName()
        responseDTO.getDateOfCreation()!=null
        responseDTO.getDateOfModified()!=null
        responseDTO.getLastLogin()!=null
        responseDTO.isActive()


    }
}
