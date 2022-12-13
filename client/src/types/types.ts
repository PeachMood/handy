export interface Image {
  src: string;
  alt: string;
}
export interface ArticleContent {
  title: string;
  subtitle: string;
  image: Image;
}

export interface Social {
  image: Image;
  href: string;
}
