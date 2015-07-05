package de.nachregenkommtsonne.myospherocontrol.backgroundservice;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.IBinder;
import de.nachregenkommtsonne.myospherocontrol.GuiStateHinter;
import de.nachregenkommtsonne.myospherocontrol.backgroundservice.controller.myo.IMyoController;
import de.nachregenkommtsonne.myospherocontrol.backgroundservice.controller.myo.IMyoEvents;
import de.nachregenkommtsonne.myospherocontrol.backgroundservice.controller.myo.MyoController;
import de.nachregenkommtsonne.myospherocontrol.backgroundservice.controller.myo.MyoEventHandler;
import de.nachregenkommtsonne.myospherocontrol.backgroundservice.controller.sphero.ISpheroController;
import de.nachregenkommtsonne.myospherocontrol.backgroundservice.controller.sphero.ISpheroEvents;
import de.nachregenkommtsonne.myospherocontrol.backgroundservice.controller.sphero.SpheroController;
import de.nachregenkommtsonne.myospherocontrol.backgroundservice.controller.sphero.SpheroEventHandler;
import de.nachregenkommtsonne.myospherocontrol.backgroundservice.servicecontroller.ServiceController;
import de.nachregenkommtsonne.myospherocontrol.backgroundservice.servicecontroller.ServiceControllerFactory;
import de.nachregenkommtsonne.myospherocontrol.backgroundservice.servicecontroller.SettingsEditor;
import de.nachregenkommtsonne.myospherocontrol.movement.IMovementCalculator;
import de.nachregenkommtsonne.myospherocontrol.movement.MovementCalculator;

public class BackgroundService extends Service
{
  private ServiceController _serviceController;
  
  public BackgroundService()
  {
    super();

    _serviceController = new ServiceControllerFactory(this).create();
    
    /*GuiStateHinter guiStateHinter = new GuiStateHinter();
    ServiceState serviceState = new ServiceState(guiStateHinter);
    INotificationUpdater notificationUpdater = new NotificationUpdater(this, serviceState);

    ServiceBinder serviceBinder = new ServiceBinder(serviceState);
    IChangedNotifier changedNotifier = new ChangedNotifier(notificationUpdater, serviceBinder);
    
    ISpheroController spheroController = new SpheroController();
    IMovementCalculator mMovementCalculator = new MovementCalculator();

    IMyoEvents myoEventHandler = new MyoEventHandler(
        serviceState,
        mMovementCalculator,
        spheroController,
        changedNotifier);

    SettingsEditor settingsEditor = new SettingsEditor();
    IMyoController myoController = new MyoController(myoEventHandler, settingsEditor);
    ISpheroEvents spheroEventHandler = new SpheroEventHandler(changedNotifier, spheroController, serviceState);

    IBluetoothStateHandler bluetoothStateHandler = new BluetoothStateHandler(changedNotifier, serviceState, myoController, spheroController);
		BroadcastReceiver serviceControllerBroadcastReceiver = new BluetoothStateBroadcastReceiver(
    		bluetoothStateHandler,
        changedNotifier);
    
		_serviceController = new ServiceController(
        myoController,
        spheroController,
        changedNotifier,
        serviceState,
        spheroEventHandler,
        serviceControllerBroadcastReceiver,
        serviceBinder);*/
}
  
  public void onCreate()
  {
    super.onCreate();

    _serviceController.start(this);
  }

  public int onStartCommand(Intent intent, int flags, int startId)
  {
    return START_STICKY;
  }

  public IBinder onBind(Intent intent)
  {
    return _serviceController.get_serviceBinder();
  }

  public void onTaskRemoved(Intent rootIntent)
  {
    super.onTaskRemoved(rootIntent);

    _serviceController.stop();
  }
}
