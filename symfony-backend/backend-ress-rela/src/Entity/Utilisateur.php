<?php

namespace App\Entity;

use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\DBAL\Types\Types;
use Doctrine\ORM\Mapping as ORM;
use App\Repository\UtilisateurRepository;
use Symfony\Component\Serializer\Annotation\Groups;

#[ORM\Entity(repositoryClass: UtilisateurRepository::class)]
class Utilisateur
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    #[Groups(["Utilisateur","Ressource", "Roles", "Categorie", "TypeRelation", "RelationUtilisateur", "MessageUtilisateur", "EtatRessource", "TypeRessource"])]
    private ?int $id = null;

    #[Groups(["Utilisateur","Ressource", "Roles", "Categorie", "TypeRelation", "RelationUtilisateur", "MessageUtilisateur", "EtatRessource", "TypeRessource"])]
    #[ORM\Column(length: 255)]
    private ?string $nom = null;

    #[Groups(["Utilisateur","Ressource", "Roles", "Categorie", "TypeRelation", "RelationUtilisateur", "MessageUtilisateur", "EtatRessource", "TypeRessource"])]
    #[ORM\Column(length: 255)]
    private ?string $prenom = null;

    #[Groups(["Utilisateur"])]
    #[ORM\Column(length: 255)]
    private ?string $mail = null;

    #[Groups(["Utilisateur"])]
    #[ORM\Column(length: 1000)]
    private ?string $motDePasse = null;

    #[Groups(["Utilisateur"])]
    #[ORM\Column(length: 255)]
    private ?string $departement = null;

    #[ORM\Column]
    #[Groups(["Utilisateur"])]
    private ?bool $estActive = null;

    #[Groups(["Utilisateur"])]
    #[ORM\Column(type: Types::DATE_MUTABLE)]
    private ?\DateTimeInterface $dateCreation = null;


    #[Groups(["Utilisateur"])]
    #[ORM\Column(type: Types::DATE_MUTABLE, nullable: true)]
    private ?\DateTimeInterface $dateDesactivation = null;

    #[Groups(["Utilisateur"])]
    #[ORM\ManyToOne(inversedBy: 'utilisateurs')]
    #[ORM\JoinColumn(nullable: false)]
    private ?Role $role = null;

    /**
     * @var Collection<int, Ressource>
     */
    #[ORM\OneToMany(targetEntity: Ressource::class, mappedBy: 'utilisateur', orphanRemoval: true)]
    #[Groups(["Utilisateur"])]
    private Collection $ressources;

    /**
     * @var Collection<int, RelationUtilisateur>
     */
    #[ORM\OneToMany(targetEntity: RelationUtilisateur::class, mappedBy: 'id_utilisateur_1', orphanRemoval: true)]
    private Collection $relationUtilisateurs;

    /**
     * @var Collection<int, MessageUtilisateur>
     */
    #[ORM\OneToMany(targetEntity: MessageUtilisateur::class, mappedBy: 'utilisateur1', orphanRemoval: true)]
    private Collection $messageUtilisateurs;

    /**
     * @var Collection<int, Commentaire>
     */
    #[ORM\OneToMany(targetEntity: Commentaire::class, mappedBy: 'utilisateur', orphanRemoval: true)]
    private Collection $commentaires;

    /**
     * @var Collection<int, Reponse>
     */
    #[ORM\OneToMany(targetEntity: Reponse::class, mappedBy: 'utilisateur')]
    private Collection $reponses;

    public function __construct()
    {
        $this->ressources = new ArrayCollection();
        $this->relationUtilisateurs = new ArrayCollection();
        $this->messageUtilisateurs = new ArrayCollection();
        $this->commentaires = new ArrayCollection();
        $this->reponses = new ArrayCollection();
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

    public function getPrenom(): ?string
    {
        return $this->prenom;
    }

    public function setPrenom(string $prenom): static
    {
        $this->prenom = $prenom;

        return $this;
    }

    public function getMail(): ?string
    {
        return $this->mail;
    }

    public function setMail(string $mail): static
    {
        $this->mail = $mail;

        return $this;
    }

    public function getMotDePasse(): ?string
    {
        return $this->motDePasse;
    }

    public function setMotDePasse(string $motDePasse): static
    {
        $this->motDePasse = $motDePasse;

        return $this;
    }

    public function getDepartement(): ?string
    {
        return $this->departement;
    }

    public function setDepartement(string $departement): static
    {
        $this->departement = $departement;

        return $this;
    }

    public function isEstActive(): ?bool
    {
        return $this->estActive;
    }

    public function setEstActive(bool $estActive): static
    {
        $this->estActive = $estActive;

        return $this;
    }

    public function getDateCreation(): ?\DateTimeInterface
    {
        return $this->dateCreation;
    }

    public function setDateCreation(\DateTimeInterface $dateCreation): static
    {
        $this->dateCreation = $dateCreation;

        return $this;
    }

    public function getDateDesactivation(): ?\DateTimeInterface
    {
        return $this->dateDesactivation;
    }

    public function setDateDesactivation(?\DateTimeInterface $dateDesactivation): static
    {
        $this->dateDesactivation = $dateDesactivation;

        return $this;
    }

    public function getRole(): ?Role
    {
        return $this->role;
    }

    public function setRole(?Role $role): static
    {
        $this->role = $role;

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
            $ressource->setUtilisateur($this);
        }

        return $this;
    }

    public function removeRessource(Ressource $ressource): static
    {
        if ($this->ressources->removeElement($ressource)) {
            // set the owning side to null (unless already changed)
            if ($ressource->getUtilisateur() === $this) {
                $ressource->setUtilisateur(null);
            }
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
            $relationUtilisateur->setIdUtilisateur1($this);
        }

        return $this;
    }

    public function removeRelationUtilisateur(RelationUtilisateur $relationUtilisateur): static
    {
        if ($this->relationUtilisateurs->removeElement($relationUtilisateur)) {
            // set the owning side to null (unless already changed)
            if ($relationUtilisateur->getIdUtilisateur1() === $this) {
                $relationUtilisateur->setIdUtilisateur1(null);
            }
        }

        return $this;
    }

    /**
     * @return Collection<int, MessageUtilisateur>
     */
    public function getMessageUtilisateurs(): Collection
    {
        return $this->messageUtilisateurs;
    }

    public function addMessageUtilisateur(MessageUtilisateur $messageUtilisateur): static
    {
        if (!$this->messageUtilisateurs->contains($messageUtilisateur)) {
            $this->messageUtilisateurs->add($messageUtilisateur);
            $messageUtilisateur->setUtilisateur1($this);
        }

        return $this;
    }

    public function removeMessageUtilisateur(MessageUtilisateur $messageUtilisateur): static
    {
        if ($this->messageUtilisateurs->removeElement($messageUtilisateur)) {
            // set the owning side to null (unless already changed)
            if ($messageUtilisateur->getUtilisateur1() === $this) {
                $messageUtilisateur->setUtilisateur1(null);
            }
        }

        return $this;
    }

    /**
     * @return Collection<int, Commentaire>
     */
    public function getCommentaires(): Collection
    {
        return $this->commentaires;
    }

    public function addCommentaire(Commentaire $commentaire): static
    {
        if (!$this->commentaires->contains($commentaire)) {
            $this->commentaires->add($commentaire);
            $commentaire->setUtilisateur($this);
        }

        return $this;
    }

    public function removeCommentaire(Commentaire $commentaire): static
    {
        if ($this->commentaires->removeElement($commentaire)) {
            // set the owning side to null (unless already changed)
            if ($commentaire->getUtilisateur() === $this) {
                $commentaire->setUtilisateur(null);
            }
        }

        return $this;
    }

    /**
     * @return Collection<int, Reponse>
     */
    public function getReponses(): Collection
    {
        return $this->reponses;
    }

    public function addReponse(Reponse $reponse): static
    {
        if (!$this->reponses->contains($reponse)) {
            $this->reponses->add($reponse);
            $reponse->setUtilisateur($this);
        }

        return $this;
    }

    public function removeReponse(Reponse $reponse): static
    {
        if ($this->reponses->removeElement($reponse)) {
            // set the owning side to null (unless already changed)
            if ($reponse->getUtilisateur() === $this) {
                $reponse->setUtilisateur(null);
            }
        }

        return $this;
    }
}
