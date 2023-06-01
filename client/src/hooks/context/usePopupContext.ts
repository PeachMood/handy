import { useContext } from 'react';

import { PopupContext } from 'contexts/PopupContext';

export const usePopupContext = () => useContext(PopupContext);
