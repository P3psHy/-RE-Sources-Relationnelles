<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use App\Repository\RelationUtilisateurRepository;
use Symfony\Component\Serializer\Annotation\Groups;

#[ORM\Entity(repositoryClass: RelationUtilisateurRepository::class)]
class RelationUtilisateur
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    #[Groups(["RelationUtilisateur"])]
    private ?int $id = null;

    #[ORM\Column]
    #[Groups(["RelationUtilisateur"])]
    private ?bool $estAccepte = null;

    #[ORM\ManyToOne(inversedBy: 'relationUtilisateurs')]
    #[ORM\JoinColumn(nullable: false)]
    #[Groups(["RelationUtilisateur"])]
    private ?TypeRelation $id_type_relation = null;

    #[ORM\ManyToOne(inversedBy: 'relationUtilisateurs')]
    #[ORM\JoinColumn(nullable: false)]
    #[Groups(["RelationUtilisateur"])]
    private ?Utilisateur $id_utilisateur_1 = null;

    #[ORM\ManyToOne(inversedBy: 'relationUtilisateurs')]
    #[ORM\JoinColumn(nullable: false)]
    #[Groups(["RelationUtilisateur"])]
    private ?Utilisateur $id_utilisateur_2 = null;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function isEstAccepte(): ?bool
    {
        return $this->estAccepte;
    }

    public function setEstAccepte(bool $estAccepte): static
    {
        $this->estAccepte = $estAccepte;

        return $this;
    }

    public function getIdTypeRelation(): ?TypeRelation
    {
        return $this->id_type_relation;
    }

    public function setIdTypeRelation(?TypeRelation $id_type_relation): static
    {
        $this->id_type_relation = $id_type_relation;

        return $this;
    }

    public function getIdUtilisateur1(): ?Utilisateur
    {
        return $this->id_utilisateur_1;
    }

    public function setIdUtilisateur1(?Utilisateur $id_utilisateur_1): static
    {
        $this->id_utilisateur_1 = $id_utilisateur_1;

        return $this;
    }

    public function getIdUtilisateur2(): ?Utilisateur
    {
        return $this->id_utilisateur_2;
    }

    public function setIdUtilisateur2(?Utilisateur $id_utilisateur_2): static
    {
        $this->id_utilisateur_2 = $id_utilisateur_2;

        return $this;
    }
}
