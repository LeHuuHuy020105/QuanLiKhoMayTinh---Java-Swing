package DAO;

public class Query {
    //    Product
    public static String insertProduct = "Insert into product(tenmay,soluong,gia,tenCPU,ram,xuatxu,cardmanhinh,mainboard,congsuatnguon,kichthuocman,dungluongpin,rom,loaimay,manhacungcap,dungluongluutru,giaban,hinhanh) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public static String updatePC = "update product set tenmay=?,soluong=?,gia=?,tenCPU=?,ram=?,xuatxu=?,mainboard=?,congsuatnguon=?,rom=?,loaimay=?,manhacungcap=?,dungluongluutru=? , giaban =? where mamay =?";

    public static String updateLaptop = "update product set tenmay=?,soluong=?,gia=?,tenCPU=?,ram=?,xuatxu=?,kichthuocman =?,dungluongpin=?,rom=?,loaimay=?,manhacungcap=?,dungluongluutru=? , giaban=? where mamay =?";

    public static String selectAllProductByType(String typeProduct) {
        return "Select * from product where loaimay = '" + typeProduct + "'";
    }

    public static String selectroductByID = "Select * from product where mamay=?";
    public static String selectAllProduct = "Select * from product";
    public static String deleteProduct = "Delete from product where mamay =?";

    //    Country
    public static String selectAllCountry = "Select * from country";
    public static String selectCountryByName = "Select * from country where tenquocgia=?";
    public static String selectCountryByID = "Select * from country where maquocgia=?";

    //    Producer
    public static String insertProducer = "Insert into producer(manhacungcap,tennhacungcap,sodienthoai,diachi) VALUES (?,?,?,?)";
    public static String updateProducer = "UPDATE producer " +
            "SET tennhacungcap = ?, diachi = ?, sodienthoai = ? " +
            "WHERE manhacungcap = ?";
    public static String selectAllProducer = "Select * from producer";
    public static String producerByID = "select * from producer where manhacungcap =?";
    public static String deleteProducer = "delete from producer where manhacungcap =?";
    public static String producerByName = "select * from producer where lower(tennhacungcap) like ?";
    public static String getPhoneByProducerId = "SELECT sodienthoai FROM producer WHERE manhacungcap = ?";
    public static String checkPhoneProducer = "select count(*) from producer where sodienthoai = ?";


    //    User
    public static String insertUser = "INSERT INTO USER (username,password,fullname,status,email,phone) VALUES (?,?,?,?,?,?)";
    public static String getCurrentUser = "SELECT * FROM USER WHERE username =? AND password =?";
    public static String updateUser = "update user set password =? , fullname =? , status =? , email =?, machinhanh=?, phone=? where id =?";
    public static String deleteUser = "delete from user where id =?";
    public static String selectAllUser = "select * from user";
    public static String getPhoneByUserId="SELECT phone FROM user WHERE id = ?";
    public static String getEmailByUserId="SELECT email FROM user WHERE id = ?";
    public static String getUsetById="select * from user where id =?";
    public static String getRoleByIDUser= "select * from user_role,role where user_id =? AND user_role.role_id = role.id";
    public static String getIDRoleByIDUser= "select * from user_role,role where user_id =? AND user_role.role_id = role.id";
    public static String getMaChiNhanhByIDUser="select * from user_role,role where user_id =? AND user_role.role_id = role.id";
    public static String nameBtn_Menu= "select * from role_interfaceuser,role,interfaceuser where name =? AND role_interfaceuser.id = role.id AND role_interfaceuser.magiaodien=interfaceuser.magiaodien ";
    public static String selectAllNotAdmin="select * from user where id >? ";
    public static String checkSDTUser = "select count(*) from user where phone = ?";
    public static String checkDataAccount="SELECT COUNT(*) FROM user WHERE username = ?";
    public static String checkEmailUser="SELECT COUNT(*) FROM user WHERE email = ?";


    //    District
    public static String selectAllByProvince = "Select * from district where province_id = ?";
    public static String districtByName = "Select * from district where name = ?";

    //    Province
    public static String selectAllProvince = "Select * from province";
    public static String provinceByName = "SELECT * FROM province WHERE name = ?";

    //    Ward
    public static String selectAllByDistrict = "Select * from wards where district_id = ?";

    //    DetailImportProduct
    public static String insertDetailImportProduct = "insert into detailimportproducts (maphieunhap,mamay,soluong) values (?,?,?)";
    //     ImportProduct
    public static String insertImportProduct = "insert into importproducts (tongtien,thoidiemtaophieu,id,trangthai) values (?,?,?,?)";
    public static String updateImportProduct = "update importproducts set trangthai =?,ngaynhandon=?, thoidiemhuyphieu= ? , thoidiemtaophieu=?  where maphieunhap =?";
    public static String selectAllImportProduct = "select * from importproducts";
    public static String getImportProductsByMaPhieuNhap = "select * from importproducts where  maphieunhap =?";

    // Branch
    public static String insertBranch = "insert into branch(tenchinhanh, diachi, tenquan, thanhpho, sodienthoai, mota) values (?,?,?,?,?,?)";
    public static String updateBranch = "update branch  set tenchinhanh =?, diachi =?, tenquan =?, thanhpho =?, sodienthoai =?, mota=? where machinhanh=?";
    public static String deleteBranch = "delete from branch where machinhanh=?";
    public static String selectAllBranch = "select * from branch";
    public static String getPhoneByBranchId = "SELECT sodienthoai FROM branch WHERE machinhanh = ?";
    public static String BranchByID = "select * from branch where machinhanh=?";
    public static String BranchByDiaChi = "select * from branch where diachi=?";
    public static String checkSDTBranch = "SELECT COUNT(*) FROM branch WHERE sodienthoai = ? AND machinhanh != ?";
    public static String checkNameBranch = "select count(*) from branch where tenchinhanh = ? ";
}