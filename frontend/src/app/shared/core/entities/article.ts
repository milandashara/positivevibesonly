import { BaseEntityInterface } from './base-entity';

export interface ArticleInterface extends BaseEntityInterface {
  id: string;
  header?: string;
  text: string;
  author: string;
}
export class Article implements ArticleInterface {
  id: string;
  header?: string;
  text: string;
  author: string;
}
