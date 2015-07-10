package de.nachregenkommtsonne.myospherocontrol.activity.controller.ui;

import de.nachregenkommtsonne.myospherocontrol.IGuiStateHinter;
import de.nachregenkommtsonne.myospherocontrol.controller.IServiceState;

public class UiUpdaterFactory implements IUiUpdaterFactory
{
  private IViewAccessor _viewAccessor;
  private IGuiStateHinter _guiStateHinter;

  public UiUpdaterFactory(IViewAccessor viewAccessor, IGuiStateHinter guiStateHinter)
  {
    _viewAccessor = viewAccessor;
    _guiStateHinter = guiStateHinter;
  }

  public UiUpdater create(IServiceState state)
  {
    return new UiUpdater(state, _viewAccessor, _guiStateHinter);
  }
}
