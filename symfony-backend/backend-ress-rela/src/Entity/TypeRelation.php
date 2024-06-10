<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use App\Repository\TypeRelationRepository;
use Doctrine\Common\Collections\Collection;
use Doctrine\Common\Collections\ArrayCollection;
use Symfony\Component\Serializer\Annotation\Groups;

#[ORM\Entity(repositoryClass: TypeRelationRepository::class)]
class TypeRelation
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    #[Groups(["TypeRelation", "Ressource", "RelationUtilisateur"])]
    private ?int $id = null;

    #[Groups(["TypeRelation", "Ressource", "RelationUtilisateur"])]
    #[ORM\Column(length: 255)]
    private ?string $nom = null;

    #[Groups(["TypeRelation", "Ressource", "RelationUtilisateur"])]
    #[ORM\Column(length: 255, nullable: true)]
    private ?string $commentaire = null;

    /**
     * @var Collection<int, Ressource>
     */
    #[ORM\ManyToMany(targetEntity: Ressource::class, mappedBy: 'typeRelations')]
    #[Groups(["TypeRelation"])]
    private Collection $ressources;

    /**
     * @var Collection<int, RelationUtilisateur>
     */
    #[ORM\OneToMany(targetEntity: RelationUtilisateur::class, mappedBy: 'id_type_relation', orphanRemoval: true)]
    private Collection $relationUtilisateurs;



    public function __construct()
    {
        $this->ressources = new ArrayCollection();
        $this->relationUtilisateurs = new ArrayCollection();
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNom(): ?string
    {
        return $this->nom;
    }

    public function setNom(string $nom): static
    {
        $this->nom = $nom;

        return $this;
    }

    public function getCommentaire(): ?string
    {
        return $this->commentaire;
    }

    public function setCommentaire(?string $commentaire): static
    {
        $this->commentaire = $commentaire;

        return $this;
    }

    /**
     * @return Collection<int, Ressource>
     */
    public function getRessources(): Collection
    {
        return $this->ressources;
    }

    public function addRessource(Ressource $ressource): static
    {
        if (!$this->ressources->contains($ressource)) {
            $this->ressources->add($ressource);
            $ressource->addTypeRelation($this);
        }

        return $this;
    }

    public function removeRessource(Ressource $ressource): static
    {
        if ($this->ressources->removeElement($ressource)) {
            $ressource->removeTypeRelation($this);
        }

        return $this;
    }

    /**
     * @return Collection<int, RelationUtilisateur>
     */
    public function getRelationUtilisateurs(): Collection
    {
        return $this->relationUtilisateurs;
    }

    public function addRelationUtilisateur(RelationUtilisateur $relationUtilisateur): static
    {
        if (!$this->relationUtilisateurs->contains($relationUtilisateur)) {
            $this->relationUtilisateurs->add($relationUtilisateur);
            $relationUtilisateur->setIdTypeRelation($this);
        }

        return $this;
    }

    public function removeRelationUtilisateur(RelationUtilisateur $relationUtilisateur): static
    {
        if ($this->relationUtilisateurs->removeElement($relationUtilisateur)) {
            // set the owning side to null (unless already changed)
            if ($relationUtilisateur->getIdTypeRelation() === $this) {
                $relationUtilisateur->setIdTypeRelation(null);
            }
        }

        return $this;
    }

}
