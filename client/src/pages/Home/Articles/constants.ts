import balcony from 'assets/images/balcony.jpg';
import blackSquare from 'assets/images/blackSquare.jpg';
import mentalCalculation from 'assets/images/mentalCalculation.jpg';
import rally from 'assets/images/rally.jpg';

import { ArticleProps } from './Article/Article';

export const initialArticles: ArticleProps[] = [
  {
    title: 'Use everywhere',
    subtitle: 'You can edit notes from your phone, tablet or computer.  Just the Internet is enough.',
    image: {
      src: balcony,
      alt: 'Balcony. Edouard Manet',
    },
    theme: 'light',
    side: 'right',
  },
  {
    title: 'Edit easily',
    subtitle: 'Due to the minimalistic interface, Handy will allow you to edit notes easily. Everything is clear without words.',
    image: {
      src: blackSquare,
      alt: 'Black Square. Kasimir Malevich',
    },
    theme: 'dark',
    side: 'left',
  },
  {
    title: 'Learn effectively',
    subtitle: 'Handy is ideal for writing class notes. Add formulas, tables, code or pictures to notes and enjoy learning!',
    image: {
      src: mentalCalculation,
      alt: 'Mental calculation. Nikolay Bogdanov-Belsky',
    },
    theme: 'light',
    side: 'right',
  },
  {
    title: 'Work fast',
    subtitle: 'We have done everything possible to make our application work quickly and you don\'t have to spend a second waiting.',
    image: {
      src: rally,
      alt: 'A Rally. Sir John Lavery',
    },
    theme: 'dark',
    side: 'left',
  },
];
