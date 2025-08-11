import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../core/services/api.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <h2 class="text-xl mb-2">Organization Form</h2>
    <form (ngSubmit)="save()" class="flex flex-col gap-2">
      <input [(ngModel)]="org.name" name="name" placeholder="Name" class="border p-2" />
      <input [(ngModel)]="org.subdomain" name="subdomain" placeholder="Subdomain" class="border p-2" />
      <button type="submit" class="bg-primary text-white p-2">Save</button>
    </form>
  `
})
export class OrganizationFormComponent {
  org: any = {};
  constructor(private api: ApiService, private route: ActivatedRoute, private router: Router) {}

  save() {
    this.api.post('/api/organizations', this.org).subscribe(() => this.router.navigate(['../'], { relativeTo: this.route }));
  }
}
