<?php

namespace App\Entity;

use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\DBAL\Types\Types;
use Doctrine\ORM\Mapping as ORM;
use App\Repository\RessourceRepository;
use Symfony\Component\Serializer\Annotation\Groups;

#[ORM\Entity(repositoryClass: RessourceRepository::class)]
class Ressource
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    #[Groups(["Utilisateur","Ressource", "Categorie", "TypeRelation", "EtatRessource", "TypeRessource"])]
    private ?int $id = null;

    #[Groups(["Utilisateur","Ressource", "Categorie", "TypeRelation", "EtatRessource", "TypeRessource"])]
    #[ORM\Column(length: 500)]
    private ?string $titre = null;

    #[Groups(["Utilisateur","Ressource", "Categorie", "TypeRelation", "EtatRessource", "TypeRessource"])]
    #[ORM\Column(length: 9999)]
    private ?string $description = null;

    #[Groups(["Utilisateur","Ressource", "Categorie", "TypeRelation", "EtatRessource", "TypeRessource"])]
    #[ORM\Column(type: Types::DATE_MUTABLE)]
    private ?\DateTimeInterface $datePublication = null;

    #[ORM\Column]
    private ?int $nbConsultation = 0;

    #[ORM\Column]
    private ?int $nbRecherche = 0;

    #[ORM\Column]
    private ?int $nbPartage = 0;

    #[ORM\ManyToOne(inversedBy: 'ressources')]
    #[ORM\JoinColumn(nullable: false)]
    #[Groups(["Ressource", "Categorie", "TypeRelation", "EtatRessource", "TypeRessource"])]
    private ?Utilisateur $utilisateur = null;

    #[ORM\ManyToOne(inversedBy: 'ressources')]
    #[ORM\JoinColumn(nullable: false)]
    #[Groups(["Ressource"])]
    private ?Categorie $categorie = null;

    /**
     * @var Collection<int, TypeRelation>
     */
    #[ORM\JoinTable(name:"_ressource_type_relation")]
    #[ORM\ManyToMany(targetEntity: TypeRelation::class, inversedBy: 'ressources')]
    #[Groups(["Ressource"])]
    private Collection $typeRelations;

    #[ORM\ManyToOne(inversedBy: 'ressources')]
    #[ORM\JoinColumn(nullable: false)]
    private ?EtatRessource $etatRessource = null;

    #[ORM\ManyToOne(inversedBy: 'ressources')]
    #[ORM\JoinColumn(nullable: false)]
    private ?TypeRessource $typeRessource = null;


    public function __construct()
    {
        $this->typeRelations = new ArrayCollection();
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getTitre(): ?string
    {
        return $this->titre;
    }

    public function setTitre(string $titre): static
    {
        $this->titre = $titre;

        return $this;
    }

    public function getDescription(): ?string
    {
        return $this->description;
    }

    public function setDescription(string $description): static
    {
        $this->description = $description;

        return $this;
    }

    public function getDatePublication(): ?\DateTimeInterface
    {
        return $this->datePublication;
    }

    public function setDatePublication(\DateTimeInterface $datePublication): static
    {
        $this->datePublication = $datePublication;

        return $this;
    }

    public function getNbConsultation(): ?int
    {
        return $this->nbConsultation;
    }

    public function setNbConsultation(int $nbConsultation): static
    {
        $this->nbConsultation = $nbConsultation;

        return $this;
    }

    public function getNbRecherche(): ?int
    {
        return $this->nbRecherche;
    }

    public function setNbRecherche(int $nbRecherche): static
    {
        $this->nbRecherche = $nbRecherche;

        return $this;
    }

    public function getNbPartage(): ?int
    {
        return $this->nbPartage;
    }

    public function setNbPartage(int $nbPartage): static
    {
        $this->nbPartage = $nbPartage;

        return $this;
    }

    public function getUtilisateur(): ?Utilisateur
    {
        return $this->utilisateur;
    }

    public function setUtilisateur(?Utilisateur $utilisateur): static
    {
        $this->utilisateur = $utilisateur;

        return $this;
    }

    public function getCategorie(): ?Categorie
    {
        return $this->categorie;
    }

    public function setCategorie(?Categorie $categorie): static
    {
        $this->categorie = $categorie;

        return $this;
    }

    /**
     * @return Collection<int, TypeRelation>
     */
    public function getTypeRelations(): Collection
    {
        return $this->typeRelations;
    }

    public function addTypeRelation(TypeRelation $typeRelation): static
    {
        if (!$this->typeRelations->contains($typeRelation)) {
            $this->typeRelations->add($typeRelation);
        }

        return $this;
    }

    public function removeTypeRelation(TypeRelation $typeRelation): static
    {
        $this->typeRelations->removeElement($typeRelation);

        return $this;
    }

    public function getEtatRessource(): ?EtatRessource
    {
        return $this->etatRessource;
    }

    public function setEtatRessource(?EtatRessource $etatRessource): static
    {
        $this->etatRessource = $etatRessource;

        return $this;
    }

    public function getTypeRessource(): ?TypeRessource
    {
        return $this->typeRessource;
    }

    public function setTypeRessource(?TypeRessource $typeRessource): static
    {
        $this->typeRessource = $typeRessource;

        return $this;
    }

}
