package de.nachregenkommtsonne.myospherocontrol.backgroundservice.binder;

import de.nachregenkommtsonne.myospherocontrol.controller.IServiceState;
import de.nachregenkommtsonne.myospherocontrol.controller.myo.IMyoController;
import de.nachregenkommtsonne.myospherocontrol.controller.sphero.ISpheroStartStopController;

public class ServiceBinderFactory
{
  public ServiceBinderFactory()
  {
  }

  public ServiceBinder create(
      IServiceState serviceState,
      IServiceState notifyingServiceState,
      ISpheroStartStopController spheroController,
      IMyoController myoController)
  {
    ButtonClickHandler buttonClickHandler = new ButtonClickHandler(spheroController, myoController, notifyingServiceState);
    ServiceBinder serviceBinder = new ServiceBinder(serviceState, buttonClickHandler);

    return serviceBinder;
  }
}