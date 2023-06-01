import { useContext } from 'react';

import { MenuContext } from 'contexts/MenuContext';

export const useMenuContext = () => useContext(MenuContext);
