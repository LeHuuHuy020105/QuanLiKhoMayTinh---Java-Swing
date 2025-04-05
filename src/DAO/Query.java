package DAO;

public class Query {
//    Product
    public static String insertProduct = "Insert into product(tenmay,soluong,gia,tenCPU,ram,xuatxu,cardmanhinh,mainboard,congsuatnguon,kichthuocman,dungluongpin,rom,loaimay,manhacungcap,dungluongluutru,giaban,hinhanh) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public static String updatePC = "update product set tenmay=?,soluong=?,gia=?,tenCPU=?,ram=?,xuatxu=?,mainboard=?,congsuatnguon=?,rom=?,loaimay=?,manhacungcap=?,dungluongluutru=? , giaban =? where mamay =?";

    public static String updateLaptop ="update product set tenmay=?,soluong=?,gia=?,tenCPU=?,ram=?,xuatxu=?,kichthuocman =?,dungluongpin=?,rom=?,loaimay=?,manhacungcap=?,dungluongluutru=? , giaban=? where mamay =?";

    public static String selectAllProductByType(String typeProduct){
        return "Select * from product where loaimay = '"+typeProduct+"'";
    }
    public static String selectroductByID = "Select * from product where mamay=?";
    public static String selectAllProduct = "Select * from product";
    public static String deleteProduct = "Delete from product where mamay =?";

//    Country
    public static String selectAllCountry ="Select * from country";
    public static String selectCountryByName ="Select * from country where tenquocgia=?";
    public static String selectCountryByID ="Select * from country where maquocgia=?";

//    Producer
    public static String insertProducer = "Insert into producer(manhacungcap,tennhacungcap,sodienthoai,diachi) VALUES (?,?,?,?)";
    public static String updateProducer ="update " +
            "Set tennhacungcap =?, diachi =? , sodienthoai =?" +
            "from producer where manhacungcap =?";
    public static String selectAllProducer = "Select * from producer";
    public static String producerByID = "select * from producer where manhacungcap =?";
    public static String deleteProducer ="delete from producer where manhacungcap =?";
    public static String producerByName ="select * from producer where lower(tennhacungcap) like ?";


//    User
    public static String insertUser = "INSERT INTO USER (username,password,fullname,status,email,machinhanh,phone) VALUES (?,?,?,?,?,?)";
    public static String getCurrentUser = "SELECT * FROM USER WHERE username =? AND password =?" ;

//    District
    public static String selectAllByProvince="Select * from district where province_id = ?";
    public static String districtByName="Select * from district where name = ?";

//    Province
    public static String selectAllProvince ="Select * from province";
    public static String provinceByName = "SELECT * FROM province WHERE name = ?";

//    Ward
    public static String selectAllByDistrict ="Select * from wards where district_id = ?";

//    DetailImportProduct
    public static String insertDetailImportProduct ="insert into detailimportproducts (maphieunhap,mamay,soluong) values (?,?,?)";
//     ImportProduct
    public static String insertImportProduct ="insert into importproducts (tongtien,thoidiemtaophieu,id,trangthai) values (?,?,?,?)";

// Branch
    public static String insertBranch = "insert into branch(tenchinhanh, diachi, tenquan, thanhpho, sodienthoai, mota) values (?,?,?,?,?,?)";
}
