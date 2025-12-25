package retry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	private static final Logger LOG = (Logger) LogManager.getLogger("Retry.class");// logManager and logger classes are used to imple retry mechanism
	private static final int maxTry = 2;// how many times retry should perform  . If any skipped, execution will be done 1 more time automtcly . so total count 4.
	private int count = 0;// count value will increment. To find how many retries are done

	@Override
	public boolean retry(final ITestResult iTestResult) {// retry is overridden from iretryanlyzer interface
	if (!iTestResult.isSuccess()) {
	if (this.count < maxTry) {
	LOG.info("Retrying test " + iTestResult.getName() + " with status "
	+ getResultStatusName(iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s).");
	this.count++;
	return true;
	}
	}
	return false;
	}

	public String getResultStatusName(final int status) {
	String resultName = null;
	if (status == 1) {
	resultName = "SUCCESS";
	}
	if (status == 2) {
	resultName = "FAILURE";
	}
	if (status == 3) {
	resultName = "SKIP";
	}
	return resultName;
	}

}
