import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { MenuItem } from '../components/menu/menuItem';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor() { }

  getMenuItems(): Observable<MenuItem[]> {
    return of([
      { name: 'Health', route: '/health', icon: 'home',
        // children: [
        //    { name: 'Quotes', route: '/' },
        // ]
      },
      { name: 'Relation', route: '/relation', icon: 'health' },
      { name: 'Finance', route: '/finance', icon: 'relation' },
      // { name: 'Account', route: 'account', icon: 'supervisor_account' },
      // { name: 'Items', icon: 'dvr', children: [
      //   { name: 'Items', route: 'item' },
      //   { name: 'Categorias', route: 'categorias', icon: 'label', children: [
      //     { name: 'Sub-Categorias', route: 'subcategorias', icon: 'adb' }
      //   ] }
      // ]},
      // { name: 'Devices', route: 'devices', icon: 'devices' },
    ]);
  }
}
