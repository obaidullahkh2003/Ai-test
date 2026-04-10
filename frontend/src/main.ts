import { bootstrapApplication } from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http';
import { provideRouter, Routes } from '@angular/router';
import { Component, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

interface Product { id: number; name: string; price: number; stock: number; }

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  template: `<div class="container"><h1>Computer Parts Store</h1>
  <p>Login is handled via Keycloak bearer tokens in the API layer.</p>
  <h2>Products</h2><ul><li *ngFor="let p of products">{{p.name}} - ${{p.price}} ({{p.stock}} left)</li></ul></div>`
})
class AppComponent {
  private http = inject(HttpClient);
  products: Product[] = [];
  ngOnInit() { this.http.get<Product[]>('/api/products').subscribe(data => this.products = data); }
}

const routes: Routes = [];
bootstrapApplication(AppComponent, { providers: [provideHttpClient(), provideRouter(routes)] });
