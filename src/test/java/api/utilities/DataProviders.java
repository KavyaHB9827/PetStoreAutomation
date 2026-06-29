package api.utilities;



import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
//dp1
    @DataProvider(name = "UserData")//userdata is name of excel sheet fRom whivh we are getting via data providers
    public String[][] getAllData() throws IOException {

        String path = System.getProperty("user.dir")
                + "\\testData\\UserData.xlsx";

       XLUtility xlutil = new XLUtility();

        int rownum = xlutil.getRowCount("Sheet1", path);
        int colcount = xlutil.getCellCount("Sheet1", path, 0);

        String[][] apidata = new String[rownum][colcount];

        for (int i = 1; i <= rownum; i++) {

            for (int j = 0; j < colcount; j++) {

                apidata[i - 1][j] =
                        xlutil.getCellData("Sheet1", path, i, j);
            }
        }

        return apidata;
    }
    //dp2
    @DataProvider(name = "UserNames")
    public String[] getUserNames() throws IOException {

       XLUtility xlutil = new XLUtility(path);

        int rownum = xlutil.getRowCount("Sheet1", null);

        String apidata[] = new String[rownum];

        for (int i = 1; i <= rownum; i++) {

            apidata[i - 1] =
                    xlutil.getCellData("Sheet1", null, i, 1);
        }

        return apidata;
    }
}  




