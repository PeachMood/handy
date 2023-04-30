import { Path, RegisterOptions } from 'react-hook-form';

declare global {
  interface Image {
    src: string;
    alt: string;
  }

  type FormOptions<T> = Partial<Record<keyof T, RegisterOptions<T, Path<T>>>>;
}
