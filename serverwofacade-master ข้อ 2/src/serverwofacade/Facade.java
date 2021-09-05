package serverwofacade;

public class Facade {
    private static Facade myFacadeObj = null;
        private Facade() {}
        public static Facade getMyFacadeObject() {
            if (myFacadeObj == null) {
                myFacadeObj = new Facade();
            } 
            return myFacadeObj;
        }
        public void Start() {
            ScheduleServer scheduleServer = new ScheduleServer();
            scheduleServer.startBooting();
	        scheduleServer.readSystemConfigFile();
	        scheduleServer.init();
            scheduleServer.initializeContext();
            scheduleServer.initializeListeners();
            scheduleServer.createSystemObjects();
            System.out.println("Start working......");
            System.out.println("After work done.........");
            scheduleServer.releaseProcesses();
            scheduleServer.destory();
            scheduleServer.destroySystemObjects();
            scheduleServer.destoryListeners();
            scheduleServer.destoryContext();
            scheduleServer.shutdown();
        }
}
