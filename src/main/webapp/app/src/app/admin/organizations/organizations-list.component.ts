import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService } from '../../core/services/api.service';
import { RouterLink } from '@angular/router';

@Component({
  standalone: true,
  imports: [CommonModule, RouterLink],
  template: `
    <h2 class="text-xl mb-2">Organizations</h2>
    <a routerLink="new" class="underline">Create</a>
    <ul>
      <li *ngFor="let o of orgs">{{o.name}}</li>
    </ul>
  `
})
export class OrganizationsListComponent implements OnInit {
  orgs: any[] = [];
  constructor(private api: ApiService) {}
  ngOnInit() {
    this.api.get<any>('/api/organizations').subscribe(res => this.orgs = res);
  }
}
