package de.nachregenkommtsonne.myospherocontrolC.activity.controller;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import de.nachregenkommtsonne.myospherocontrolC.activity.controller.ui.IUiOnUiThreadUpdater;
import de.nachregenkommtsonne.myospherocontrolC.backgroundservice.binder.IServiceBinderForUI;
import de.nachregenkommtsonne.myospherocontrolC.backgroundservice.binder.IServiceStateChangedListener;
import de.nachregenkommtsonne.myospherocontrolC.controller.IServiceState;

public class BackgroundServiceConnection implements ServiceConnection
{
  private IUiOnUiThreadUpdater _uiOnUiThreadUpdater;
  private IServiceBinderForUI _myBinder;

  public BackgroundServiceConnection(IUiOnUiThreadUpdater uiOnUiThreadUpdater)
  {
    _uiOnUiThreadUpdater = uiOnUiThreadUpdater;
  }

  public void onServiceConnected(ComponentName name, IBinder service)
  {
    _myBinder = (IServiceBinderForUI) service;

    _myBinder.setServiceStateChangedListener(new IServiceStateChangedListener()
    {
      public void changed()
      {
        updateUi();
      }
    });

    updateUi();
  }

  public void updateUi()
  {
    IServiceState state = _myBinder.getState();
    _uiOnUiThreadUpdater.updateUiOnUiThread(state);
  }

  public void onServiceDisconnected(ComponentName name)
  {
    _myBinder.setServiceStateChangedListener(null);
  }

  // TODO: move to own interface
  public IServiceBinderForUI get_myBinder()
  {
    return _myBinder;
  }
}
