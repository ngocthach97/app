package com.example.app.Service.ServiceImpl;

import com.example.app.Model.DTO.UsersDTO;
import com.example.app.Model.Entity.District;
import com.example.app.Model.Entity.Province;
import com.example.app.Model.Entity.Users;
import com.example.app.Model.Entity.Ward;
import com.example.app.Model.Mapper.UserMapper;
import com.example.app.Repository.Repository.DistrictRepository;
import com.example.app.Repository.Repository.ProvinceRepository;
import com.example.app.Repository.Repository.UserRepository;
import com.example.app.Repository.Repository.WardRepository;
import com.example.app.Service.Service.UserService;
import com.example.app.Utility.Common.Constant;
import com.example.app.Utility.Common.File;
import com.example.app.Utility.Common.Response.NotificationResponse;
import com.example.app.Utility.Common.ValidationProperties;
import com.example.app.Utility.Common.Validator;
import com.example.app.Utility.Errors.BadRequestAlertException;
import com.example.app.Utility.Errors.EntityName;
import com.example.app.Utility.Errors.ErrorKey;
import com.example.app.Utility.Errors.LabelKey;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    public static final String TEMPLATE_PATH = "/file/user_imformation_report.xlsx";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private WardRepository wardRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<UsersDTO> getAllUsersDTO() {
        List<Users> usersList = userRepository.findAll();
        List<UsersDTO> usersDTOList = userMapper.toListEntityListDTO(usersList);
        return usersDTOList;
    }

    @Override
    public NotificationResponse importUsers(MultipartFile file) {
        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            File excelHelper = new File();
            Sheet sheet = workbook.getSheetAt(0);
            // kiểm tra đối tượng sheet
            if (Validator.isNull(sheet)) {

            }
            // kiểm tra định dạng file

            // xóa các hàng cột trống
            int rowLastNumber = sheet.getLastRowNum();

            Row rowFinal = sheet.getRow(rowLastNumber);

            while (excelHelper.checkIfRowIsEmpty(rowFinal)) {

                sheet.removeRow(rowFinal);

                rowLastNumber = sheet.getLastRowNum();

                rowFinal = sheet.getRow(rowLastNumber);
            }

            for (Row row : sheet) {
                if (row.getRowNum() < 1) {
                    continue;
                }
                Users _users = new Users();
                StringBuilder error = new StringBuilder();
                for (Cell cell : row) {
                    String value = excelHelper.readCellContent(cell);
                    switch (cell.getColumnIndex()) {
                        case 1:
                            // Username
                            if (Validator.isNotNull(value)) {
                                if (value.length() < ValidationProperties.usernameMinLength || value.length() > ValidationProperties.usernameMaxLength) {

                                }
                                if (!Validator.isUsername(value)) {

                                }
                                if (userRepository.existsByUsername(value)) {

                                }
                                _users.setUsername(value);
                            }
                            break;
                        case 2:
                            // Password
                            if (Validator.isNotNull(value)) {
                                if (value.length() < ValidationProperties.passwordMinLength || value.length() > ValidationProperties.passwordMaxLength) {

                                }
                                if (!Validator.isPassword(value)) {

                                }
                                _users.setPassword(value);
                            }
                            break;
                        case 3:
                            // Role
                            if (Validator.isNotNull(value)) {
                                _users.setRoles(value);
                            }
                            break;
                        case 4:
                            // Name
                            if (Validator.isNotNull(value)) {
                                if (value.length() < ValidationProperties.nameMinLength || value.length() > ValidationProperties.nameMaxLength) {

                                }
                                _users.setName(value);
                            }
                            break;
                        case 5:
                            // Gender
                            if (Validator.isNotNull(value)) {
                                _users.setGender(Integer.parseInt(value));
                            }
                            break;
                        case 6:
                            // Phone
                            if (Validator.isNotNull(value)) {
                                if (value.length() > ValidationProperties.phoneMinLength || value.length() < ValidationProperties.phoneMaxLength) {
                                    throw new BadRequestAlertException(LabelKey.USER.LABEL_USER_PHONE, EntityName.USER, ErrorKey.ERROR_INVALID_PHONE);
                                }
                                if (!Validator.isPhone(value)) {

                                }

                                if (userRepository.existsByPhone(value)) {

                                }
                                _users.setPhone(value);
                            }
                            break;
                        case 7:
                            //Gmail
                            if (Validator.isNotNull(value)) {
                                if (value.length() < ValidationProperties.gmailMinLength || value.length() > ValidationProperties.gmailMaxLength) {

                                }
                                if (!Validator.isGmail(value)) {

                                }
                                if (userRepository.existsByGmail(value)) {

                                }
                                _users.setGmail(value);
                            }
                            break;
                        case 8:
                            // Province Code
                            if (Validator.isNotNull(value)) {
                                Province province = provinceRepository.findByProvinceCode(value);
                                if (Validator.isNull(province)) {

                                }
                                _users.setProvinceCode(value);
                            }
                            break;
                        case 9:
                            //District Code
                            if (Validator.isNotNull(value)) {
                                District district = districtRepository.findByDistrictCode(value);
                                if (Validator.isNull(district)) {

                                }
                                if (Validator.isNotNull(_users.getProvinceCode()) && _users.getProvinceCode().equals(district.getProvinceCode())) {
                                    _users.setDistrictCode(value);
                                }
                            }
                            break;
                        case 10:
                            //Ward Code
                            if (Validator.isNotNull(value)) {
                                Ward ward = wardRepository.findByWardCode(value);
                                if (Validator.isNull(ward)) {

                                }
                                if (Validator.isNotNull(_users.getDistrictCode()) && _users.getDistrictCode().equals(ward.getDistrictCode())) {
                                    _users.setWardCode(value);
                                }
                            }
                            break;
                        default:
                            break;
                    }
                }
                // không có lỗi thì insert data vào db
                if (error.length() <= 0) {
                    LOGGER.error(_users);
                    _users.setStatus(Constant.EntityStatus.ACTIVE);
                    userRepository.save(_users);

                    return NotificationResponse.builder()
                            .message("Upload File Excel Successfully !")
                            .status(true)
                            .build();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return NotificationResponse.builder()
                .message("Upload File Excel Failed !")
                .status(false)
                .build();
    }

    @Override
    @Transactional
    public void exportUsers(HttpServletResponse response) {
        List<Users> list = userRepository.findAll();
        try {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            try (InputStream is = new ClassPathResource(TEMPLATE_PATH).getInputStream()) {
                try (OutputStream os = response.getOutputStream()) {
                    Context context = new Context();
                    context.putVar("lists", list);
                    JxlsHelper.getInstance().processTemplate(is, os, context);
                }
                response.flushBuffer();
            }
        } catch (IOException e) {
           LOGGER.error(e.getMessage());
        }
    }

    @Override
    public UsersDTO createUser(Users users) {

        if(Validator.isNull(users.getId())){
            throw new BadRequestAlertException(LabelKey.USER.LABEL_USER_ID,EntityName.USER,ErrorKey.ERROR_INVALID_ID);
        }
        if(Validator.isNull(users.getName())){
            throw new BadRequestAlertException(LabelKey.USER.LABEL_USER_NAME,EntityName.USER,ErrorKey.ERROR_INVALID_NAME);
        }
        if(Validator.isNull(users.getGender())){
            throw new BadRequestAlertException(LabelKey.USER.LABEL_USER_NAME,EntityName.USER,ErrorKey.ERROR_INVALID_NAME);
        }
        if(Validator.isNull(users.getPhone())){

        }
        if(! Validator.isPhone(users.getPhone())){

        }
        if(! userRepository.existsByPhone(users.getPhone())){

        }
        if(Validator.isNull(users.getGmail())){

        }
        if(! Validator.isGmail(users.getGmail())){

        }
        if(userRepository.existsByGmail(users.getGmail())){


        }

        if(Validator.isNull(users.getPassword())){

        }
        if(users.getPassword().length() > ValidationProperties.passwordMaxLength ||
                users.getPassword().length() < ValidationProperties.passwordMinLength){

        }
        if(Validator.isNull(users.getUsername())){

        }
        if(! Validator.isUsername(users.getUsername())){

        }
        if(Validator.isNull(users.getProvinceCode())){

        }

        Province province = provinceRepository.findByProvinceCode(users.getProvinceCode());
        if(Validator.isNull(province.getProvinceCode())){

        }

        if(Validator.isNull(users.getDistrictCode())){

        }

        District district = districtRepository.findByDistrictCode(users.getProvinceCode());
        if(Validator.isNull(district.getDistrictCode())){

        }

        if(Validator.isNull(users.getWardCode())){


        }
        Ward ward = wardRepository.findByWardCode(users.getWardCode());
        if(Validator.isNull(ward.getWardCode())){

        }

        return userMapper.toEntityDTO(userRepository.save(users));
    }
}
