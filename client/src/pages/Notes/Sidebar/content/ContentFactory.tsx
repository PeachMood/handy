import React, { FC } from 'react';

import { Content } from 'contexts/SidebarContext';

import { NotesContent } from './NotesContent';
import { SearchContent } from './SearchContent';
import { FavouritesContent } from './FavouritesContent';

export const ContentFactory: FC<{ content: Content }> = ({ content }) => {
  switch (content) {
    case Content.Notes:
      return <NotesContent />;
    case Content.Search:
      return <SearchContent />;
    case Content.Favourites:
      return <FavouritesContent />;
    default:
      return null;
  }
};
