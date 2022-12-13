import balcony from 'assets/images/balcony.jpg';
import blackSquare from 'assets/images/blackSquare.jpg';
import mentalCalculation from 'assets/images/mentalCalculation.jpg';
import rally from 'assets/images/rally.jpg';

import twitterIcon from 'assets/images/twitterIcon.svg';
import telegramIcon from 'assets/images/telegramIcon.svg';
import facebookIcon from 'assets/images/facebookIcon.svg';

import { ArticleContent, Social } from 'types/types';

export const initialArticlesContent: ArticleContent[] = [
  {
    title: 'Use everywhere',
    subtitle: 'You can edit notes from your phone, tablet or computer.  Just the Internet is enough.',
    image: {
      src: balcony,
      alt: 'Balcony. Edouard Manet',
    },
  },
  {
    title: 'Edit easily',
    subtitle: 'Due to the minimalistic interface, Handy will allow you to edit notes easily. Everything is clear without words.',
    image: {
      src: blackSquare,
      alt: 'Black Square. Kasimir Malevich',
    },
  },
  {
    title: 'Learn effectively',
    subtitle: 'Handy is ideal for writing class notes. Add formulas, tables, code or pictures to notes and enjoy learning!',
    image: {
      src: mentalCalculation,
      alt: 'Mental calculation. Nikolay Bogdanov-Belsky',
    },
  },
  {
    title: 'Work fast',
    subtitle: 'We have done everything possible to make our application work quickly and you don\'t have to spend a second waiting.',
    image: {
      src: rally,
      alt: 'A Rally. Sir John Lavery',
    },
  },
];

export const socialIcons: Social[] = [
  {
    image: {
      src: twitterIcon,
      alt: 'Twitter',
    },
    href: 'https://twitter.com/handy',
  },
  {
    image: {
      src: telegramIcon,
      alt: 'Telegram',
    },
    href: 'https://t.me/handy',
  },
  {
    image: {
      src: facebookIcon,
      alt: 'Facebook',
    },
    href: 'https://www.facebook.com/handy',
  },
];
