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
import com.example.app.Utility.Common.File;
import com.example.app.Utility.Common.ValidationProperties;
import com.example.app.Utility.Common.Validator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

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
    public UsersDTO postUsersDTO(MultipartFile file) {
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
                                if (value.length() < ValidationProperties.passwordMinLength || value.length() > ValidationProperties.phoneMaxLength) {

                                }
                                if (!Validator.isPassword(value)) {

                                }
                                _users.setPassword(value);
                            }
                            break;
                        case 3:
                            // Name
                            if (Validator.isNotNull(value)) {
                                if (value.length() < ValidationProperties.nameMinLength || value.length() > ValidationProperties.nameMaxLength) {

                                }
                                _users.setName(value);
                            }
                            break;
                        case 4:
                            // Phone
                            if (Validator.isNotNull(value)) {
                                if (value.length() < ValidationProperties.phoneMinLength || value.length() > ValidationProperties.phoneMaxLength) {

                                }
                                if (!Validator.isPhone(value)) {

                                }

                                if (userRepository.existsByPhone(value)) {

                                }
                                _users.setPhone(value);
                            }
                            break;
                        case 5:
                            //Gmail
                            if (Validator.isNotNull(value)) {
                                if (value.length() < ValidationProperties.gmailMinLength && value.length() > ValidationProperties.gmailMaxLength) {

                                }
                                if (!Validator.isGmail(value)) {

                                }
                                if (userRepository.existsByGmail(value)) {

                                }
                                _users.setGmail(value);
                            }
                            break;
                        case 6:
                            // Province Code
                            if (Validator.isNotNull(value)) {
                                Province province = provinceRepository.findByProvinceCode(value);
                                if (Validator.isNull(province)) {

                                }
                                _users.setProvinceCode(Long.parseLong(value));
                            }
                            break;
                        case 7:
                            //District Code
                            if (Validator.isNull(value)) {
                                District district = districtRepository.findByDistrictCode(value);
                                if (Validator.isNull(district)) {

                                }
                                if (Validator.isNotNull(_users.getProvinceCode()) && Validator.equals(district.getProvinceCode(), _users.getProvinceCode())) {
                                    _users.setDistrictCode(Long.parseLong(value));
                                }
                            }
                            break;
                        case 8:
                            //Ward Code
                            if (Validator.isNotNull(value)) {
                                Ward ward = wardRepository.findByWardCode(value);
                                if (Validator.isNull(ward)) {

                                }
                                if (Validator.isNotNull(_users.getDistrictCode()) && Validator.equals(_users.getDistrictCode(), ward.getDistrictCode())) {
                                    _users.setWardCode(Long.parseLong(value));
                                }
                            }
                            break;
                        default:
                            break;
                    }

                }
                // không có lỗi thì insert data vào db
                if (error.length() <= 0) {
                    userRepository.save(_users);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
