package de.nachregenkommtsonne.myospherocontrol.interfaces;

import com.thalmic.myo.Myo;
import com.thalmic.myo.Quaternion;

import de.nachregenkommtsonne.myospherocontrol.MyoStatus;

public interface IMyoEvents {
	void myoControlActivated();
	void myoControlDeactivated();
	void myoOrientationDataCollected(Quaternion rotation, Myo myo);
	void myoStateChanged(MyoStatus myoStatus);
}
