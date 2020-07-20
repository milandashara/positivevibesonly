import {Component, Input, OnInit} from '@angular/core';
import {Article} from '../../core/entities/article';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {

  constructor() { }

  @Input() article: Article;

  ngOnInit(): void {
  }

}
