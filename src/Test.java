
public class Test {

	private static volatile MultValCache cache;

	//@Immutable
	class MultValCache {
		private final String lastRequest;
		private final String lastResult;
		public MultValCache(String req, String result) {
			this.lastRequest = req;
			this.lastResult = result;
		}
		public String getResult(String req) {
			if (lastRequest == null || !lastRequest.equalsIgnoreCase(req)) {
				return null;
			}else {
				return this.lastResult;
			}
		}
	}
}
