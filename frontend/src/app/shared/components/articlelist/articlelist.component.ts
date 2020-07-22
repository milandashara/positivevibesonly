import { Component, OnInit, Input } from '@angular/core';
import {PageEvent} from '@angular/material/paginator';
import {animate, state, style, transition, trigger} from '@angular/animations';
import { ArticleService } from '../../services/article.service';
import { Article } from '../../core/entities/article';

// export interface Article {
//   header: string;
//   author: string;
//   description: string;
//   text: string;
// }

// const ELEMENT_DATA: Article[] = [
//   {header: 'Header', author: "Author",description: "Description"}
// ];


@Component({
  selector: 'app-articlelist',
  templateUrl: './articlelist.component.html',
  styleUrls: ['./articlelist.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class ArticlelistComponent implements OnInit {

  // MatPaginator Inputs
  length = 100;
  pageSize = 10;
  pageSizeOptions: number[] = [5, 10, 25, 100];
  displayedColumns: string[] = ['header', 'author'];
  pageIndex: number;
  @Input() dataSource: Article[] ;
  @Input() category:string ;
  expandedElement: Article | null;
  

  // MatPaginator Output
  pageEvent: PageEvent;

  constructor(private articleService:ArticleService) { }

  ngOnInit(): void {
    this.articleService.getArticle(this.category,this.pageSize,0).subscribe(data => {
      this.dataSource = data.articles;
      this.pageIndex = data.pageIndex;
      this.pageSize = data.pageSize;
      this.length = data.total;
    })
  }

  getArticles(event?:PageEvent){
    this.articleService.getArticle(this.category,event.pageSize,event.pageIndex).subscribe(data => {
      this.dataSource = data.articles;
      this.pageIndex = data.pageIndex;
      this.pageSize = data.pageSize;
      this.length = data.total;
    })

    return event;

  }


  setPageSizeOptions(setPageSizeOptionsInput: string) {
    if (setPageSizeOptionsInput) {
      this.pageSizeOptions = setPageSizeOptionsInput.split(',').map(str => +str);
    }
  }

}
