<?php

namespace App\Form;

use App\Entity\RelationUtilisateur;
use App\Entity\TypeRelation;
use App\Entity\Utilisateur;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class RelationUtilisateurType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('estAccepte')
            ->add('id_type_relation', EntityType::class, [
                'class' => TypeRelation::class,
                'choice_label' => 'id',
            ])
            ->add('id_utilisateur_1', EntityType::class, [
                'class' => Utilisateur::class,
                'choice_label' => 'id',
            ])
            ->add('id_utilisateur_2', EntityType::class, [
                'class' => Utilisateur::class,
                'choice_label' => 'id',
            ])
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => RelationUtilisateur::class,
        ]);
    }
}
