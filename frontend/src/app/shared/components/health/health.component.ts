import { Component, OnInit } from '@angular/core';
import {Article} from '../../core/entities/article';

@Component({
  selector: 'app-health',
  templateUrl: './health.component.html',
  styleUrls: ['./health.component.css']
})
export class HealthComponent implements OnInit {

  constructor() { }

  selectedArticle: Article;

  ngOnInit(): void {
    this.selectedArticle = {id: '1', header: 'Article name', text: 'article text', author: 'author'};
  }

}
