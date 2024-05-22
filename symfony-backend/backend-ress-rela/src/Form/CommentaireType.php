<?php

namespace App\Form;

use App\Entity\Commentaire;
use App\Entity\Ressource;
use App\Entity\Utilisateur;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class CommentaireType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('contenu')
            ->add('date_commentaire', null, [
                'widget' => 'single_text'
            ])
            ->add('ressource', EntityType::class, [
                'class' => Ressource::class,
'choice_label' => 'id',
            ])
            ->add('utilisateur', EntityType::class, [
                'class' => Utilisateur::class,
'choice_label' => 'id',
            ])
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Commentaire::class,
        ]);
    }
}
