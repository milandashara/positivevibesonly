import { BaseEntityInterface } from './base-entity';

export interface ArticleInterface extends BaseEntityInterface {
  header:string
  name:string
  body:string
  category:string
  subcategory:string
  author:string
}
export class Article implements ArticleInterface {
  id: string
  header:string
  name:string
  body:string
  category:string
  subcategory:string
  author:string
  description: string
}

export interface PaginatedArticle {
  articles:Article[]
  pageIndex:number
  totalPages:number
  pageSize:number
  total:number
}
