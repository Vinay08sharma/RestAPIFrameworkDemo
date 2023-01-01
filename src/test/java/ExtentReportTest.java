import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

public class ExtentReportTest {
    @Test
    public void extentReportTest(){
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("index.html");
        extentReports.attachReporter(sparkReporter);

        extentReports.createTest("My First Test")
                .log(Status.PASS,"This is the logging event of my first test & it is PASSED !!!");

        extentReports.createTest("My Second Test")
                .log(Status.PASS,"This is the logging event of my Second test & it is PASSED !!!");

        extentReports.flush();
    }
}
