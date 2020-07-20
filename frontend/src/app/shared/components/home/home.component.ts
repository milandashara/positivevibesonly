import { Component, OnInit } from '@angular/core';
import { MenuItem } from '../menu/menuItem';
import { MenuService } from '../../services/menu.service';
import { environment } from 'src/environments/environment';
import {Article} from '../../core/entities/article';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  opened = true;
  appName: string;
  menuItems: MenuItem[];
  selectedArticle: Article;
  selectedCategory: string;

  constructor(private menuService: MenuService, private route: ActivatedRoute) {
    this.appName = environment.appName;

  }

  ngOnInit() {
    this.menuService.getMenuItems().subscribe(items =>
      this.menuItems = items
    ).unsubscribe();

    this.selectedArticle = {id: '1', header: 'Article name', text: 'article text', author: 'author'};
    this.selectedCategory = this.route.snapshot.data.category;
  }

}
