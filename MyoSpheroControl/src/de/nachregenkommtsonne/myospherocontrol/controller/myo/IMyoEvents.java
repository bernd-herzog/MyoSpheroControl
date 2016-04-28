package de.nachregenkommtsonne.myospherocontrol.controller.myo;

import com.thalmic.myo.Myo;
import com.thalmic.myo.Quaternion;

public interface IMyoEvents
{
  void myoControlActivated();

  void myoControlDeactivated();

  void myoOrientationDataCollected(Quaternion rotation, Myo myo);

	void stopControlMode();
}