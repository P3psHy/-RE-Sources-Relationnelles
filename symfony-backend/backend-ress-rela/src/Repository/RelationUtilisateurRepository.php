<?php

namespace App\Repository;

use App\Entity\RelationUtilisateur;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;
use phpDocumentor\Reflection\Types\Boolean;

/**
 * @extends ServiceEntityRepository<RelationUtilisateur>
 */
class RelationUtilisateurRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, RelationUtilisateur::class);
    }

    //    /**
    //     * @return RelationUtilisateur[] Returns an array of RelationUtilisateur objects
    //     */
    //    public function findByExampleField($value): array
    //    {
    //        return $this->createQueryBuilder('r')
    //            ->andWhere('r.exampleField = :val')
    //            ->setParameter('val', $value)
    //            ->orderBy('r.id', 'ASC')
    //            ->setMaxResults(10)
    //            ->getQuery()
    //            ->getResult()
    //        ;
    //    }

    //    public function findOneBySomeField($value): ?RelationUtilisateur
    //    {
    //        return $this->createQueryBuilder('r')
    //            ->andWhere('r.exampleField = :val')
    //            ->setParameter('val', $value)
    //            ->getQuery()
    //            ->getOneOrNullResult()
    //        ;
    //    }


    public function findByUserid(int $userId){

        return $this->createQueryBuilder('ru')
            ->where('ru.id_utilisateur_1 = :userId')
            ->orWhere('ru.id_utilisateur_2 = :userId')
            ->setParameter('userId', $userId)
            ->getQuery()
            ->getResult();
    }

}
