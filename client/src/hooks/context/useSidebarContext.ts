import { useContext } from 'react';

import { SidebarContext } from 'contexts/SidebarContext';

export const useSidebarContext = () => useContext(SidebarContext);
