package view;

import manager.ManageProduct;
import model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuProduct {
    ManageProduct manageProduct = new ManageProduct();
    Scanner inputInt = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    public void showMainMenu(){
        int choice;
        do {
            System.out.println("=====Menu Quản Lý Sản Phẩm =====\n1.Thêm mới sản phẩm.\n2.Sửa sản phẩm theo Id.\n3.Xóa sản phẩm theo id.\n" +
                    "4.Lấy ra tất cả sản phẩm.\n5.Tìm kiếm sản phẩm theo tên gần đúng.\n6.Nhập vào loại sản phẩm và lấy ra tất cả các sản phẩm cùng loại.\n" +
                    "7.Tìm kiếm sản phẩm theo Id.\n0.Thoát.");
            System.out.println("Xin mời nhập sự lựa chọn");
            choice = inputInt.nextInt();
            switch (choice){
                case  1:
                    showMenuAdd();
                    break;
                case  2:
                    showMenuEdit();
                    break;
                case 3:
                    showMenuDelete();
                    break;
                case 4:
                    showAll();
                    break;
                case 5:
                    showMenuShowNameProduct();
                    break;
                case 6:
                    showMenuProductSameType();
                    break;
                case 7:
                   showMenuSearchById();
                    break;
            }
        } while (choice != 0);

    }
    public void showMenuAdd(){
        System.out.println("=======Đây là mục thêm mới sản phẩm =====");
        System.out.println("Nhập id sản phẩm muốn thêm mới");
        int id = inputInt.nextInt();
        System.out.println("Nhập tên sản phẩm muốn thêm mới");
        String name = inputString.nextLine();
        System.out.println("Nhập số lượng sản phẩm muốn thêm mới");
        int quantity = inputInt.nextInt();
        System.out.println("Nhập giá của sản phẩm muốn thêm mới : ");
        double price = inputInt.nextDouble();
        System.out.println("Nhập loại của sản phẩm: ");
        int type = inputInt.nextInt();

        Product product = new Product(id,name,quantity,price,type);
        manageProduct.add(product);
        System.out.println("=======Đã thêm mới thành công =====");

    }

    public void showMenuEdit(){
        System.out.println("=======Đây là mục sửa dữ liệu sản phẩm =====");
        System.out.println("Nhập id sản phẩm muốn sửa");
        int id = inputInt.nextInt();
        if (manageProduct.findById(id)== -1){
            System.out.println("Không có sản phẩm này.");
        }
        else {
            System.out.println("Nhập tên sản phẩm muốn sửa đổi");
            String name = inputString.nextLine();
            System.out.println("Nhập số lượng sản phẩm muốn sửa đổi");
            int quantity = inputInt.nextInt();
            System.out.println("Nhập giá của sản phẩm muốn sửa đổi : ");
            double price = inputInt.nextDouble();
            System.out.println("Nhập loại của sản phẩm: ");
            int type = inputInt.nextInt();
            Product product = new Product(id,name,quantity,price,type);
            manageProduct.edit(id,product);
            System.out.println("=======Đã sửa đổi thành công =====");

        }

    }

    public void showMenuDelete(){
        System.out.println("=======Đây là mục xóa sản phẩm =====");
        System.out.println("Nhập id muốn xóa");
        int id = inputInt.nextInt();
        if (manageProduct.findById(id)== -1){
            System.out.println("Không có sản phẩm này.");
        }
        else
        {manageProduct.delete(id);}
        System.out.println("=======Đã xóa thành công =====");
    }
    public void showAll(){
        System.out.println("Danh sách sản phẩm  : ");
        ArrayList<Product> list= manageProduct.findAll();
        for (Product product:list) {
            System.out.println(product);
        }
    }
    public void showMenuShowNameProduct(){
        System.out.println("=======Đây là mục tìm kiếm sản phẩm  theo tên gần đúng  =====");
        System.out.println("Nhập ký tự muốn tìm kiếm");
        String charactor = inputString.nextLine();
        ArrayList<Product>list= manageProduct.findAll();
        ArrayList<Product>newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().toLowerCase().contains(charactor.toLowerCase())){
                newList.add(list.get(i));
            }
        }
        System.out.println("Danh sách sản phẩm  có ký tự : " + charactor+ " là : ");
        for (Product product:newList) {
            System.out.println(product);
        }
    }
    public void showMenuProductSameType(){
        System.out.println("=======Đây là mục tìm kiếm và lấy ra sản phẩm cùng loại  =====");
        System.out.println("Nhập loại sản phẩm  bạn muốn tìm kiếm");
        int type = inputInt.nextInt();
        ArrayList<Product>list= manageProduct.findAll();
        ArrayList<Product>newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getType()== type){
                newList.add(list.get(i));
            }
        }

        int index = manageProduct.findByType(type);
        if (index == -1){
            System.out.println("Không có sản phẩm này nhé.");
        }else {
            System.out.println("Những sản phẩm có loại"+type+ "là : ");
            for (Product product:newList) {
                System.out.println(product);
            }
        }
    }
    public void showMenuSearchById(){
        System.out.println("=======Đây là mục tìm kiếm sản phẩm  theo Id =====");
        System.out.println("Nhập id tên sản phẩm  bạn muốn tìm kiếm");
        int id = inputInt.nextInt();
        ArrayList<Product>list= manageProduct.findAll();
        int index = manageProduct.findById(id);
        if (index == -1){
            System.out.println("Không có sản phẩm này nhé.");
        } else {
            System.out.println(list.get(index));
        }

    }



}
