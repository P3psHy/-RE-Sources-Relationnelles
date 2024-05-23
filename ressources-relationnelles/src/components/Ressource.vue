<template>
  <ion-card>
      <!-- Movie poster at the top of the card -->
      <img :src="url" />
      <ion-card-header>
          <!-- Show the movie title, Average votes and description -->
          <ion-card-title>{{ movie.title }}</ion-card-title>
          <ion-card-subtitle
              >Rating: {{ movie.vote_average }}
              <ion-icon :icon="star"></ion-icon
          ></ion-card-subtitle>
      </ion-card-header>

      <ion-card-content>
          {{ movie.overview }}
      </ion-card-content>
  </ion-card>
</template>

<script>
// Remove typescript
import {
  IonCard,
  IonCardContent,
  IonCardSubtitle,
  IonCardTitle,
  IonIcon,
} from "@ionic/vue";
import { star } from "ionicons/icons";
import { defineComponent } from "vue";

export default defineComponent({
  components: {
      IonCard,
      IonCardContent,
      IonCardSubtitle,
      IonCardTitle,
      IonIcon,
  },
  // Movie props from the parent component
  props: ["movie"],
  setup() {
      return { star };
  },
  data() {
      return {
          // Use a placeholder in case there is no poster
          url:
              this.movie.backdrop_path != null
                  ? "https://image.tmdb.org/t/p/original/" +
                    this.movie.backdrop_path
                  : "./assets/placeholder.jpg",
      };
  },
});
</script>