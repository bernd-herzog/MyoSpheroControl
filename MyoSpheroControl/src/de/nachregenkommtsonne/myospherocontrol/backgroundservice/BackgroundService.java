package de.nachregenkommtsonne.myospherocontrol.backgroundservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import de.nachregenkommtsonne.myospherocontrol.backgroundservice.servicecontroller.ServiceController;
import de.nachregenkommtsonne.myospherocontrol.backgroundservice.servicecontroller.ServiceControllerFactory;

public class BackgroundService extends Service
{
  private ServiceControllerFactory _serviceControllerFactory;
  private ServiceController _serviceController;

  public BackgroundService()
  {
    super();

    _serviceControllerFactory = new ServiceControllerFactory(this);
    _serviceController = _serviceControllerFactory.createServiceController();
  }
  
  public void onCreate()
  {
    super.onCreate();

    _serviceController.onCreate(this);
  }

  public int onStartCommand(Intent intent, int flags, int startId)
  {
    return START_STICKY;
  }

  public IBinder onBind(Intent intent)
  {
    return _serviceController.get_binder();
  }

  public void onTaskRemoved(Intent rootIntent)
  {
    super.onTaskRemoved(rootIntent);

    _serviceController.serviceStopped();
  }
}
