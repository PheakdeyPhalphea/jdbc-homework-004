package unitl;

import controller.UserController;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

public class UntilTable {
    private final UserController userController;
    public UntilTable(){
        userController = Singleton.userController();
    }
    public static void welcomeTable (){
        Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE , ShownBorders.SURROUND);
        table.addCell("1. Display All User");
        table.addCell("2. Update User");
        table.addCell("3. Delete User");
        table.addCell("4. Insert User");
        table.addCell("5. Exit");
        System.out.println(table.render());
    }
    public  void displayUserTable (){
        Table table = new Table(7, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE);
        table.addCell("ID");
        table.addCell("UUID");
        table.addCell("UserName");
        table.addCell("UserEmail");
        table.addCell("UserPassword");
        table.addCell("IsDeleted");
        table.addCell("IsVerified");
        userController.getUser().forEach(e -> {
            table.addCell(e.getUserId().toString());
            table.addCell(e.getUserUUID());
            table.addCell(e.getUserName());
            table.addCell(e.getUserEmail());
            table.addCell(e.getUserPassword());
            table.addCell(e.getIsDeleted().toString());
            table.addCell(e.getIsVerified().toString());
        });
        System.out.println(table.render());
    }
}
